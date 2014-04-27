#!/usr/bin/python

import sys
# Import modules for CGI handling
import cgi
import cgitb; cgitb.enable()
# Import modules for MySQLdb handling. Will need to install
import MySQLdb

conn = MySQLdb.connect (host = "",
                         user = "www",
                         passwd = "",
                         db = "tutorial_db")

# Create instance of FieldStorage 
form = cgi.FieldStorage()
# Get data from fields
username = form.getvalue('username')
password  = form.getvalue('pass')

with conn:
	cursor = conn.cursor ()
	#pass a tuple from the first command line argument
	cursor.execute("SELECT first,last,email FROM users WHERE username = %s AND password=(select md5(concat(%s,salt)) FROM users WHERE username=%s)", (username,password,username) )
	rows = cursor.fetchall ()
	print "Content-type:text/html\r\n\r\n"
	print "<html><body>";
	if rows[0]:
		print "Welcome %s %s, your email is: %s"%(rows[0])
	else:
		print "Sorry, bad login"
	print "</body></html>"