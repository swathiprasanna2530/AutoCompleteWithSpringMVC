<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="<c:url value="/resources/core/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/core/jquery.autocomplete.min.js" />"></script>
<link href="<c:url value="/resources/core/main.css" />" rel="stylesheet">
</head>
<body>
  <h2>Spring MVC</h2>

  <form action="${pageContext.request.contextPath}/searchEmployee" modelAttribute="employee" method="get">
	<input type="text"  id="w-input-search" name="empName" value="">
	<span>
	  <button id="button-id" type="submit">Search</button>
	</span>
  </form>

  <script type="text/javascript">
  
  $(document).ready(function() {

	$('#w-input-search').autocomplete({
		serviceUrl: '${pageContext.request.contextPath}/getEmployees',
		paramName: "firstName",
		delimiter: ",",
	   transformResult: function(response) {

		return {
		  suggestions: $.map($.parseJSON(response), function(item) {
		      return { value: item.firstName, data: item.empId };
		   })

		 };

            }

	 });

  });
  </script>

</body>
</html>