TOKEN=$(aws ecr get-authorization-token --output text \
--query 'authorizationData[].authorizationToken' \
| base64 -D | cut -d: -f2)

echo "$TOKEN"

docker login -u AWS -p "$TOKEN" 602041469765.dkr.ecr.us-west-2.amazonaws.com/hiking-thru-life-ecr
