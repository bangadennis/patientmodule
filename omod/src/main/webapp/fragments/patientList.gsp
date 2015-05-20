<table>
    <tr>
        <th>${ ui.message("Patient.givenname") }</th>
        <th>${ ui.message("Patient.middlename") }</th>
        <th>${ ui.message("Patient.gender") }</th>
    </tr>
    <% if (patients) { %>
    <% patients.each { %>
    <tr>
        <td>${ ui.format(it.givenName) }</td>
        <td>${ ui.format(it.middleName) }</td>
        <td>${ ui.format(it.gender) }</td>
    </tr>
    <% } %>
    <% } else { %>
    <tr>
        <td colspan="4">${ ui.message("general.none") }</td>
    </tr>
    <% } %>
</table>