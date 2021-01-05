%{-- Include Main Layout --}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <h1 style="font-size: 20px">Create Contact</h1>
        <span class="float-right">
            <div class="btn-group">
                <g:link url="/" class="button"><i class="fas fa-home"></i></g:link>
                <g:link controller="person" action="index" class="button-viewAll"><g:message code="view.all"/></g:link>
            </div>
        </span>
    </div>
    <div class="card-body">
        <g:form controller="person" action="save">
            %{-- Partial Templating --}%
            <g:render template="form"/>
            <div class="form-action-panel">
                <g:submitButton class="button-save" name="save" value="${g.message(code: "save")}"/>
                <g:link controller="person" action="index" class="button-cancel"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>