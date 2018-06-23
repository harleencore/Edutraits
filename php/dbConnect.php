<?php
 define('HOST','182.55.83.189');
 define('USER','monoshuman');
 define('PASS','humansofmono');
 define('DB','tutorstructure');
 define('PORT', '3306' )

 $con = mysqli_connect(HOST,USER,PASS,DB,PORT) or die('Unable to Connect');
