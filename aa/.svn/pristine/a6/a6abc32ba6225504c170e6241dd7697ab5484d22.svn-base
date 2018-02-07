<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"></jsp:include>

<h3>Registration</h3>
<br>
<form action='/index/add' method='post' enctype="application/json">

	<table class='table table-hover table-responsive table-bordered'>

		<tr>
            <td><b>Name</b></td> 
            <td><input type='text' name='name' class='form-control'  required /></td>
        </tr>
         <tr>
            <td><b>Svn Location</b></td> 
            <td><input type='text' name='svnLocation' class='form-control'  required/></td>
        </tr>
         <tr>
            <td><b>Svn User Name</b></td> 
            <td><input type='text' name='svnUserName' class='form-control'  required/></td>
        </tr>
         <tr>
            <td><b>Svn Password</b></td> 
            <td><input type="password" name='svnPassword' class='form-control'  required/></td>
        </tr>
         <tr>
            <td><b>Git Location</b></td> 
            <td><input type='text' name='gitLocation' class='form-control'  required/></td>
        </tr>
         <tr>
            <td><b>Git User Name</b></td> 
            <td><input type='text' name='gitUserName' class='form-control'  required/></td>
        </tr>
        <tr>
            <td><b>Git Password</b></td> 
            <td><input type="password" name='gitPassword' class='form-control'  required/></td>
        </tr>
        <tr>
		<tr>
			<td></td>
			<td>
				<button type="submit" class="btn btn-primary">Register</button>
			</td>
		</tr>

	</table>
	<b><c:out value="${error}"></c:out></b>
</form>



<h3>List Of Entries</h3>
<br>
<table class="table table-hover">

	<thead>
		<tr>
			<th><b> Name</b></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="model">
			<tr>
				<td><c:out value="${model.name}"></c:out>
				</td>
				<td>
					<form method="post" action="/index/edit">
					<input type="hidden" value="${model.name}" name="name">
					<input type="submit" value="Edit" class="btn btn-primary"/>
					
					
					</form>
				</td>
				<td>
					<form method="post" action="/index/delete">
						<input type="hidden" value="${model.name}" name="name" />
						<input type="submit" value="Delete" class="btn btn-primary"  />					
					</form>
				</td>
			</tr>

		</c:forEach>
	</tbody>
</table>
</div>

 <jsp:include page="footer.jsp"></jsp:include>