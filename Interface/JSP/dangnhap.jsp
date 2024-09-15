<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1, width=device-width">
    <link rel="stylesheet"  href="./dangnhap.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@400&display=swap" />
</head>

<body>
    <div class="ng-nhp">
        <div class="form-log-in">
            <form action="loginServlet" method="POST">
                <div class="input-field">
                    <div class="label">Tài Khoản</div>
                    <input class="input" type="text" name="username" placeholder="Xin mời nhập tài khoản" required>
                </div>
                <div class="input-field1">
                    <div class="label">Mật khẩu</div>
                    <input class="input" type="password" name="password" placeholder="Xin mời nhập mật khẩu" required>
                </div>
                <div class="checkbox-field">
                    <div class="checkbox-and-label">
                        <input class="checkbox" type="checkbox" name="rememberMe">
                        <div class="description">Lưu mật khẩu</div>
                    </div>
                    <div class="description-row">
                        <div class="check-icon"></div>
                        <div class="description"></div>
                    </div>
                </div>
                <div class="button-group">
                    <button type="submit" class="button" style="color: white;">Đăng nhập</button>
                </div>
            </form>
            <a href="lostpass.html" class="forgot-password">Quên mật khẩu?</a>
        </div>
    </div>
</body>
</html>
