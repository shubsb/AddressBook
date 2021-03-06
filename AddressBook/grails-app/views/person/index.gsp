%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <h1 style="font-size: 20px">Contact List</h1>

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
            <g:link url="/" class="button"><i class="fas fa-home"></i></g:link>
            <g:link controller="person" action="create" class="button"><g:message code="create"/></g:link>
            <g:link controller="person" action="index" class="button-viewAll"><g:message code="view.all"/></g:link>
        </div>
        </span>
    </div>


    %{-- Table Panel --}%
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-light">
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
                                <g:link controller="person" action="edit" class="button-book" id="${info.id}"><i class="fas fa-edit"></i></g:link>
                                <g:link controller="person" action="delete" id="${info.id}" class="button-book"><i class="fas fa-trash"></i></g:link>
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
