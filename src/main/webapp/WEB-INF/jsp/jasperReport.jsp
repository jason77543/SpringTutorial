<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jasper Report</title>
</head>
<body>
	<form method="Get" action="/report/export">
		<p>報表類型：
			<select name="reportType">
				<option value="PDF">PDF</option>
				<option value="Excel">Excel</option>
			</select>
		</p>
		<input type="submit" value="下載">
	</form>
</body>
</html>