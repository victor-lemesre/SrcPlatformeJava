<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Product Selection</title>
</head>
<body>
    <h1>Product Selection</h1>
    <form action="basket" method="post">
        <label for="product">Choose a product:</label>
        <select id="product" name="product">
            <option value="pen">Pen</option>
            <option value="marker">Marker</option>
            <option value="eraser">Eraser</option>
        </select>
        <button type="submit">Add to Basket</button>
    </form>
</body>
</html>




