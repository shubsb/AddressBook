%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="person" args="['List Of']"/>

        %{--Actions--}%
        <span class="float-right">

        %{--Search Panel--}%
        <div class="btn-group">
            <g:form contoller="person" action="index" method="GET">
                <div class="input-group" id="search-area">
                    <g:select name="colName" class="form-control" from="[firstName:'First Name', lastName:'Last Name', address:'Address', city:'City', postalCode:'Postal Code']"
                        value="${params?.colName}" optionKey="key" optionValue="value"/>
                    <g:textField name="colValue" class="form-control" value="${params?.colValue}"/>
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit">Search</button>
                    </span>
                </div>
            </g:form>
        </div>

        %{-- Create and Reload--}%
        <div class="btn-group">
            <g:link controller="person" action="create" class="btn btn-success"><g:message code="create"/></g:link>
            <g:link controller="person" action="index" class="btn btn-primary"><g:message code="reload"/></g:link>
        </div>
        </span>
    </div>


    %{-- Table Panel --}%
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <g:sortableColumn property="firstName" title="${g.message(code:"first.name")}"/>
                <g:sortableColumn property="lastName" title="${g.message(code:"last.name")}"/>
                <g:sortableColumn property="address" title="${g.message(code:"address")}"/>
                <g:sortableColumn property="city" title="${g.message(code:"city")}"/>
                <g:sortableColumn property="postalCode" title="${g.message(code:"postal.Code")}"/>
                <th class="action-row"><g:message code="action"/></th>
            </tr>
            </thead>

            <tbody>
                <g:each in="${personList}" var="info">
                    <tr>
                        <td>${info?.firstName}</td>
                        <td>${info?.lastName}</td>
                        <td>${info?.address}</td>
                        <td>${info?.city}</td>
                        <td>${info?.postalCode}</td>


                        %{-- Table Action --}%
                        <td>
                            <div class="btn-group">
                                <g:link controller="person" action="details" class="btn btn-secondary" id="${info.id}"><i class="fas fa-eye"></i></g:link>
                                <g:link controller="person" action="edit" class="btn btn-secondary" id="${info.id}"><i class="fas fa-edit"></i></g:link>
                                <g:link controller="person" action="delete" id="${info.id}" class="btn btn-secondary delete-confirmation"><i class="fas fa-trash"></i></g:link>
                            </div>
                        </td>
                    </tr>
                </g:each>
            </tbody>
        </table>

    %{-- Pagination Area --}%
    <div class="paginate">
        <g:paginate total="${total ?: 0}"/>
    </div>

    </div>
 </div>
</div>