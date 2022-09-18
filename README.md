# Sojern Application

# Compare versions - Utility

HttpMethod: POST  
URL: http://localhost:8080/compare-versions

Sample Request:
```
{
	"version1": "1.2",
	"version2": "3.4"
}
```
Sample Response:
```
{
    "versionResult": -1
}
```

# Math API - Application

# Testing Endpoints

1. /min - given list of numbers and a quantifier (how many) provides min number(s)  

HttpMethod: POST   
URL: http://localhost:8080/min

Sample Request:
```
{
	"numbers": [56,2,53,57,3,77],
	"quantifier": 4
} 
```
Sample Response:
```
{
    "numbers": [
        2,
        3,
        53,
        56
    ]
}
```

2. /max - given list of numbers and a quantifier (how many) provides max number(s)

HttpMethod: POST   
URL: http://localhost:8080/max

Sample Request:
```
{
	"numbers": [56,2,53,57,3,77],
	"quantifier": 3
}
```
Sample Response:
```
{
    "numbers": [
        77,
        57,
        56
    ]
}
```

3. /avg - given list of numbers calculates their average

HttpMethod: POST   
URL: http://localhost:8080/avg

Sample Request:
```
{
	"numbers": [56,2,53,57,3,77]
}
```
Sample Response:
```
{
    "average": 41.333333333333336
}
```

4. /median - given list of numbers calculates their median

HttpMethod: POST   
URL: http://localhost:8080/median

Sample Request:
```
{
	"numbers": [56,2,53,57,3,77]
}
```
Sample Response:
```
{
    "median": 54.5
}
```

5. /percentile - given list of numbers and quantifier 'q', compute the qth percentile of the list elements

HttpMethod: POST   
URL: http://localhost:8080/percentile

Sample Request:
```
{
	"numbers": [56,2,53,57,3,77],
	"quantifier": 30
}
```
Sample Response:
```
{
    "percentile": 3
}
```
