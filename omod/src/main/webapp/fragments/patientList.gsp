
    <tr>
        <th>${ ui.message("Given Name") }</th>
        <th>${ ui.message("Middle") }</th>
        <th>${ ui.message("Gender") }</th>
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