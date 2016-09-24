<table class="table">
    <thead>
    <tr>
        <th>#</th>
        <th>Dated</th>
        <th>Name</th>
        <th>Access</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${teamMemberList}" var="teamMember" status="i">
        <tr>
            <td>${i + 1}</td>
            <td>${teamMember.dateCreated.format("MMM dd, yyyy")}</td>
            <td>${teamMember.memberName}</td>
            <td><g:message code="team.member.access.${teamMember.accessLevel.name()}"/></td>
            <td><a href="javascript:void(0)"><i
                    class="fa fa-eye"></i> View
            </a>&nbsp;|&nbsp;
                <a href="javascript:void(0)"><i class="fa fa-pencil-square-o"></i> Edit</a>&nbsp;|&nbsp;
                <a href="javascript:void(0)" onclick="removeTeamMember('${teamMember.uniqueId}')"><i class="fa fa-trash"
                                                                                                     aria-hidden="true"></i>
                    Delete</a></td>
        </tr>
    </g:each>
    </tbody>
</table>