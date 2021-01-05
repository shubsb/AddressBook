<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Address Book"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>


    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
    <script type="text/javascript">
        <g:if test="${flash?.message && flash?.message?.info}">
            jQuery(document).ready(function() {
                messageBox.showMessage(Boolean(${flash.message?.success}), "${flash.message?.info}");
            });
        </g:if>
    </script>
    <g:layoutHead/>
</head>

<body>

<div class="book-image">
    <g:layoutBody/>
</div>

</body>
</html>
