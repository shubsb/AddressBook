
<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        Create Person
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="icon" type="image/x-ico" href="/assets/favicon.ico"/>

    <link rel="stylesheet" href="/assets/bootstrap.css?compile=false" />
<link rel="stylesheet" href="/assets/grails.css?compile=false" />
<link rel="stylesheet" href="/assets/main.css?compile=false" />
<link rel="stylesheet" href="/assets/mobile.css?compile=false" />
<link rel="stylesheet" href="/assets/application.css?compile=false" />



        <meta name="layout" content="main"/>



</head>

<body>
  <a href="#create-person" class="skip" tabindex="-1">Skip to content&hellip;</a>
  <div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="/">Home</a></li>
        <li><a href="/person/index" class="list">Person List</a></li>
    </ul>
  </div>
  <div id="create-person" class="content scaffold-create" role="main">
    <h1>Create Person</h1>
    <form action="/person/save" method="post" >
      <fieldset class="form">

        <!First Name>
        <div class='fieldcontain required'>
          <label for='fName'>First Name
            <span class='required-indicator'>*</span>
          </label>
          <input type="text" name="fName" value="" required="" id="fName" />
        </div>

        <!Last Name>
        <div class='fieldcontain required'>
          <label for='lName'>Last Name
            <span class='required-indicator'>*</span>
          </label>
          <input type="text" name="lName" value="" required="" id="lName" />
        </div>

        <!Address>
        <div class='fieldcontain required'>
          <label for='address'>Address
            <span class='required-indicator'>*</span>
          </label><input type="text" name="address" value="" required="" id="address" />
        </div>

        <!City>
        <div class='fieldcontain required'>
          <label for='city'>City
            <span class='required-indicator'>*</span>
          </label><input type="text" name="city" value="" required="" id="city" />
        </div>

        <!Postal Code>
        <div class='fieldcontain required'>
          <label for='postalCode'>Postal Code
            <span class='required-indicator'>*</span>
          </label>
          <input type="text" name="postalCode" value="" required="" id="postalCode" />
        </div>
      </fieldset>
      <fieldset class="buttons">
          <input type="submit" name="create" class="save" value="Create" id="create" />
      </fieldset>
    </form>
  </div>



<div id="spinner" class="spinner" style="display:none;">
    Loading&hellip;
</div>

<script type="text/javascript" src="/assets/jquery-3.3.1.min.js?compile=false" ></script>
<script type="text/javascript" src="/assets/bootstrap.js?compile=false" ></script>
<script type="text/javascript" src="/assets/popper.min.js?compile=false" ></script>
<script type="text/javascript" src="/assets/application.js?compile=false" ></script>


</body>
</html>
