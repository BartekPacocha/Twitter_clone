# Twitter_clone
Twitter clone

# API

Get user wall
Returns a list of published tweets
GET /api/ 
RequestBody:
```
{
	"userid" : [String] Required
}
```

Add tweet
Add tweet for specified user, if userid is null, create new user
POST /api/
RequestBody:
```
{
    "userid" : [String]
    "message" : [String] Required
}
```

Get timeline
Returns a list of messages posted by all follow people, for specified user 
GET /api/follow/
RequestBody:
```
{
    "userid" : [String] Required
}
```

Follow another user
Add user find by followid to follow list for specified user
POST /api/follow/
RequestBody:
```
{
    "userid" : [String] Required
    "followid" : [String] Required
}
```