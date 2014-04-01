<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="content-language" content="ru" />
<title>Spring MVC Application</title>

<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-responsive.css"/>"
	rel="stylesheet">

<script src="<c:url value="/resources/js/jquery-1.11.0.js"/>"
	type="text/javascript"></script>
</head>

<body>
	<script type="text/javascript">
		function showHide(element_id) {
			if (document.getElementById(element_id)) {
				var obj = document.getElementById(element_id);
				if (obj.style.display != "") {
					obj.style.display = ""; //Show element
				} else
					obj.style.display = "none"; //Hide element
			}
			//If element with id not found, then show message
			else
				alert("Element with id: " + element_id + " not found!");
		}
	</script>

	<script type="text/javascript">
		function switchEditElements(element_id) {
			showHide("editbottom" + element_id);
			showHide("savebottom" + element_id);
			switchDisabledElement("phonenum"+element_id);
			switchDisabledElement("phonetype"+element_id);
			switchDisabledElement("phonecomment"+element_id);
		}
	</script>
	<script type="text/javascript">
		function switchDisabledElement(element_id) {
			if(document.getElementById(element_id).disabled) {
				document.getElementById(element_id).disabled=false;
			} else {
				document.getElementById(element_id).disabled=true;
			}
		}
	</script>
	
	<script type="text/javascript">
		function editContactAjaxPost(element_id) {
			var phoneid=element_id;
			var phonenum=$('#phonenum'+element_id).val();
			var phonetypeid=$('#phonetype'+element_id).val();
			var phonecomment=$('#phonecomment'+element_id).val();
			$.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/edit/contact/ajax.html",
                data: "phoneid="+phoneid+"&phonenum=" + encodeURIComponent(phonenum)+"&phonetypeid="+phonetypeid+"&phonecomment="+phonecomment,
                success: function(response){
                    $('#info').html(unescape(response));
                    switchEditElements(element_id);
                },
                error: function(e){
                    alert('Error: ' + e);
                    console.log('xhRequest: ' + xhRequest + "\n");
                    console.log('ErrorText: ' + ErrorText + "\n");
                    console.log('thrownError: ' + thrownError + "\n");
                }
            });
 		}
	</script>
	
	<script type="text/javascript">
	
	</script>

	<div class="container">
		<div class="row">
			<div>
				<h3>Client's contact information</h3>
				<c:if test="${!empty phones}">

					<table class="table table-bordered table-striped" border="1">
						<thead>
							<tr>
								<th><spring:message code="label.firstname" /></th>
								<th><spring:message code="label.lastname" /></th>
								<th><spring:message code="label.middlename" /></th>
								<th><spring:message code="label.phone" /></th>
								<th><spring:message code="label.phonetype" /></th>
								<th><spring:message code="label.phonedescription" /></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${phones}" var="phone">
								<tr>
									<th>${phone.client.firstname}</th>
									<th>${phone.client.lastname}</th>
									<th>${phone.client.middlename}</th>
									<th><input id="phonenum${phone.id}" size="14" value="${phone.phoneNumber}" disabled="disabled"/></th>
									<th><select id="phonetype${phone.id}" disabled="disabled">
											<c:forEach items="${phoneTypes}" var="phonet">
												<c:choose>
													<c:when test="${phonet.type==phone.typer.type}">
														<option selected="selected" value="${phonet.type}" label="${phonet.typeName}" />
													</c:when>
													<c:otherwise>
														<option value="${phonet.type}" label="${phonet.typeName}" />
													</c:otherwise>
												</c:choose>	
											</c:forEach>
										</select>
									</th>

									<th><textarea id="phonecomment${phone.id}" rows="2" cols="10" disabled="disabled">${phone.description}</textarea></th>
									<td>
										<input id="editbottom${phone.id}" type="submit"
										class="btn btn-danger btn-mini"
										value="<spring:message code="bottom.edit"/>"
										onclick="switchEditElements('${phone.id}')" /> 
										<input id="savebottom${phone.id}" type="submit" class="btn btn-mini"
										style="display: none;"
										value="<spring:message code="bottom.saveedit"/>"
										onclick="editContactAjaxPost('${phone.id}')" /></td>
								</tr>
							</c:forEach>
							<tr><td colspan="7"><div id="info" style="color: green;" lang="ru"></div></td></tr>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>