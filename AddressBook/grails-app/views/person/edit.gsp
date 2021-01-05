%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <h1 style="font-size: 20px">Update Contact</h1>
        <span class="float-right">
            <div class="btn-group">
                <g:link url="/" class="button"><g:message code="home"/></g:link>
                <g:link controller="person" action="create" class="button"><i class="fas fa-home"></i></g:link>
                <g:link controller="person" action="index" class="button-viewAll"><g:message code="view.all"/></g:link>
            </div>
        </span>
    </div>

    <div class="card-body">
        <g:form controller="person" action="update">
            <g:hiddenField name="id" value="${person.id}"/>
            <g:render template="form" model="[edit:'yes']"/>
            <div class="form-action-panel">
                <g:submitButton class="button-viewAll" name="update" value="${g.message(code: "update")}"/>
                <g:link controller="person" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>