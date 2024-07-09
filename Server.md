```shell
docker run -v "$PWD/data":/var/lib/mysql  --name mysql8 -e MYSQL_ROOT_PASSWORD=itspwd6tfc^YHN -p 53306:3306 -d mysql:8.2
```


## Testing Commands
```shell
cd ~/projects/huari-home-java/
docker build -f Dockerfile -t veda-source/cms:v1.0 .
docker stop cms-be && docker rm cms-be
docker run  --name cms-be -e ENV=testing -p 58080:8080 -v ~/files:/huari/files -d veda-source/cms:v1.0

cd ~/projects/huari-home-java/
docker build -f admin3-ui/Dockerfile -t huari/cms-be-front:v1.0 ./admin3-ui
docker stop huari-nginx && docker rm huari-nginx
docker run  --name huari-nginx -p 80:80 -d huari/cms-be-front:v1.0

cd ~/projects/huari-pc/
docker build -f Dockerfile -t huari/huari-www:v1.0 .
docker stop huari-www && docker rm huari-www
docker run  --name huari-www -p 58081:80 -d huari/huari-www:v1.0
```

## Production Commands
```shell
cd ~/project/veda-source-cms-java/
docker build -f Dockerfile -t veda-source/cms:v1.0 .
docker stop cms-be && docker rm cms-be
docker run  --name cms-be -e ENV=production -p 58080:8080 -v ~/files:/veda-source-cms-java/files -d veda-source/cms:v1.0

cd ~/projects/huari-home-java/
docker build -f admin3-ui/Dockerfile -t huari/cms-be-front:v1.0 ./admin3-ui
docker stop huari-nginx && docker rm huari-nginx
docker run  --name huari-nginx -p 80:80 -p 443:443 -d huari/cms-be-front:v1.0

cd ~/projects/huari-pc/
docker build -f Dockerfile -t huari/huari-www:v1.0 .
docker stop huari-www && docker rm huari-www
docker run  --name huari-www -p 58081:80 -d huari/huari-www:v1.0

docker run  --name huari-prerender -p 53000:3000 -d konghangdocker/prerender:v1.0

```

```http request
http://116.62.188.66:58080/admin/swagger-ui/index.html
```

```shell
testing: ssh root@116.62.188.66
production: ssh root@117.50.210.137
pwd: 7c3cD505
```

## 依赖版本
```shell
node 16+
npm 8+
```
