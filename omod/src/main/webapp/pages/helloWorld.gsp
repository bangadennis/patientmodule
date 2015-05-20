Hello World Kenyans<b>Java</b>
<br>
${ ui.includeFragment("uiframework", "helloUser", [ user: authenticatedUser ]) }
%{--${ ui.includeFragment("patientmodule", "encountersToday") }--}%
<br>
<br>
<% if (context.authenticated) { %>
And a special hello to you, $context.authenticatedUser.personName.fullName.
Your roles are:
<% context.authenticatedUser.roles.findAll { !it.retired }.each { %>
$it.role ($it.description)
<% } %>
<% } else { %>
You are not logged in.
<% } %>