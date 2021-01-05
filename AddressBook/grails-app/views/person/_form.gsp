<div class="form-group">
    <label><g:message code="first.name"/> *</label>
    <g:textField name="firstName" class="form-control" value="${person?.firstName}" placeholder="Please enter a First Name"/>
    <UIHelper:renderErrorMessage fieldName="firstName" model="${person}" errorMessage="Please Enter A First Name!"/>
</div>

<div class="form-group">
    <label><g:message code="last.name"/> *</label>
    <g:textField name="lastName" class="form-control" value="${person?.lastName}" placeholder="Please enter a Last Name"/>
    <UIHelper:renderErrorMessage fieldName="lastName" model="${person}" errorMessage="Please Enter A Last Name!"/>
</div>

<div class="form-group">
    <label><g:message code="address"/> *</label>
    <g:textField name="address" class="form-control" value="${person?.address}" placeholder="Please enter a Address"/>
    <UIHelper:renderErrorMessage fieldName="address" model="${person}" errorMessage="Please Enter An Address!"/>
</div>

<div class="form-group">
    <label><g:message code="city"/> *</label>
    <g:textField name="city" class="form-control" value="${person?.city}" placeholder="Please enter a City"/>
    <UIHelper:renderErrorMessage fieldName="city" model="${person}" errorMessage="Please Enter A City!"/>
</div>

<div class="form-group">
    <label><g:message code="postal.Code"/> *</label>
    <g:textField name="postalCode" class="form-control" value="${person?.postalCode}" placeholder="Please enter a Postal Code"/>
    <UIHelper:renderErrorMessage fieldName="postalCode" model="${person}" errorMessage="Please Enter A Postal Code!"/>
</div>