<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Автосалон</title>
    <link rel="stylesheet" type="text/css" href="/css/style.x60084.css"/>
</head>
<body>
<h1>Автосалон</h1>
<h3>Add cars to list</h3>
<form action="/add" method="post">
    <table border="1px">
        <tr>
            <td>
                <label>Название</label>
                <input type="text" name="name">
            </td>
            <td>
                <label>Цвет</label>
                <input type="text" name="color">
            </td>
            <td>
                <label>Дата выпуска</label>
                <input type="date" name="date">
            </td>
            <td>
                <label>Цена</label>
                <input type="cost" name="cost">
            </td>
            <td>
                <input type="submit" value="add cars">
            </td>
        </tr>

    </table>
</form>
<br>
<br>
<h2>Cars list(cars count : ${carsCount})</h2>
<h3><a href = "/filter/removeAll">Сбросить фильтры</a></h3>
<table border="1px">
    <tr>
        <td><a href="/filter/Id">Id</a></td>
        <td><a href="/filter/ObjectId">ObjectId</a></td>
        <td><a href="/filter/name">Название</a></td>
        <td><a href="/filter/color">Цвет</a></td>
        <td><a href="/filter/date">Дата выпуска</a></td>
        <td><a href="/filter/cost">Цена</a></td>
        <td>Удалить из списка</td>
    </tr>
    <#list carsList as car>
    <tr>
        <td>${car.id}</td>
        <td>${car.objectId}</td>
        <td>${car.name}</td>
        <td>${car.color}</td>
        <td>${car.date}</td>
        <td>${car.cost}</td>
        <td><a href="${'/delete/'+car.id}">Delete</a></td>
    </tr>
    </#list>
</table>
</body>
</html>
