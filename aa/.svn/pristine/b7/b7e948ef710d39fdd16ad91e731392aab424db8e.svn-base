<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">

	<h3>Registration</h3>
	<form action='/index/update' method="post">

		<table class='table table-hover table-responsive table-bordered'>

			<tr>
            <td><b>Name</b></td>
            <td><input type='text' name='name' class='form-control' value="${model.name}" /></td>
        </tr>
         <tr>
            <td><b>Svn Location</b></td> 
            <td><input type='text' name='svnLocation' class='form-control'  value="${model.svnLocation}"/></td>
        </tr>
         <tr>
            <td><b>Svn User Name</b></td> 
            <td><input type='text' name='svnUserName' class='form-control'  value="${model.svnUserName}"/></td>
        </tr>
         <tr>
            <td><b>Svn Password</b></td> 
            <td><input type="password" name='svnPassword' class='form-control'  /></td>
        </tr>
         <tr>
            <td><b>Git Location</b></td> 
            <td><input type='text' name='gitLocation' class='form-control'  value="${model.gitLocation}"/></td>
        </tr>
         <tr>
            <td><b>Git User Name</b></td> 
            <td><input type='text' name='gitUserName' class='form-control'  value="${model.gitUserName}"/></td>
        </tr>
        <tr>
            <td><b>Git Password</b></td> 
            <td><input type="password" name='gitPassword' class='form-control'  /></td> 
        </tr>

			<input type='hidden' name='id' rows='5' class='form-control' name='id'
				value="${model.id}" />
			<tr>
				<td></td>
				<td>
					<button type="submit" class="btn btn-primary">Update Information</button>
				</td>
			</tr>

		</table>
			<b><c:out value="${error}"></c:out></b>
	</form>


</div>

<jsp:include page="footer.jsp"></jsp:include>