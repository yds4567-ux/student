<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생관리 시스템</title>
</head>

<body>

<table border="1" align="center">

    <tr>
        <th colspan="2">학생관리 시스템</th>
    </tr>

    <tr>
        <td colspan="2">

            <form action="/student/insert">

                <input type="text" name="name"
                    placeholder="이름"><br>

                <input type="text" name="kor"
                    placeholder="국어 점수"><br>

                <input type="text" name="eng"
                    placeholder="영어 점수"><br>

                <input type="text" name="math"
                    placeholder="수학 점수"><br>

                <button type="submit">신규 등록</button>

            </form>

        </td>
    </tr>

    <tr>
        <td colspan="2" align="center">

            <a href="/student/list">
                목록 출력
            </a>

        </td>
    </tr>

</table>

</body>
</html>