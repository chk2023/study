<?php
    $link = mysqli_connect('localhost', 'root', 'kongnpark', 'opentutorials');
    if (!$link) {
        error_log(('no'. mysqli_connect_errno()));
    }
?>