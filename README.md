# DateTimeFormat
This application used to find the specific date time format used while formating the DateTime

To find out format deploy this application,
by calling POST on "/dateFormat" REST api with input date in 'date' required parameter gives the DateTime format
ex:-

http://localhost:8080/dateFormat?date=2000-10-31T01:30:00.000-05:00

o/p : 
[
    "yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
    "yyyy-MM-dd"
]
