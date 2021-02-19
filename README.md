1._编写代码,本地启动能否正常运行_；
2._编译打包，pom继承parent，并且添加打包插件_:
  `mvn clean package -Dmaven.test.skip=true`
  --测试jar能否正常启动
  `java -jar cloud-k8s.jar`
  --如果打成war，要将war包移动到tomcat/webapps目录下

3._编写Dockerfile_;

4._构建本地Docker镜像_：
  `docker build --tag=cloud-k8s:latest .`
  --测试镜像能否运行
  docker run -d -p 8080:8080 cloud-k8s
  curl localhost:8080

5.给本地镜像打标签，并上传镜像到DockerHub:
  docker tag cloud-k8s:latest thewaytosuccess/repo01:cloud-k8s
  docker login -u root -p root
  docker push thewaytosuccess/repo01:cloud-k8s

6.创建控制器deployment，并且由控制器自动创建pod：
  kubectl run cloud-k8s --image=thewaytosuccess/repo01:cloud-k8s --port=8080 --image-pull-policy=IfNotPresent
  --镜像拉取策略：IfNotPresent/Always/Never;

7.查看pod是否创建成功：
  kubectl get deployments
  kubectl get pods
  --如果启动失败，查看失败原因：
  kubectl describe pod POD_NAME

8.将deployment暴露为service：
  kubectl expose deployment/cloud-k8s --type=NodePort

9.查看暴露的服务：
  kubectl get svc/services
  --查看主节点ip：
  kubectl cluster-info
  --访问：curl http://MASTER_IP:SERVICE_PORT;

10.查看日志：
  kubectl logs -f --tail=10 POD_NAME [-n NAMESPACE=default]

11.删除：
  kubectl delete deployment cloud-k8s
  kubectl delete pod POD_NAME
  kubectl delete service SERVICE_NAME

12.通过yaml创建deployment/service：
  kubectl create -f service.yaml
  kubectl create -f deployment.yaml

13.扩缩容：
  kubectl scale --replicas=2 deployment/cloud-k8s

14.修改yaml配置文件，使之重新生效：
  kubectl apply -f deployment.yaml

15.启动minikube:
  minikube start --registry-mirror=http://registry.docker-cn.com
  minikube stop

16.docker相关指令：
   docker search mysql
   docker pull hub.c.163.com/library/mysql
   docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root mysql
   docker logs -f CONTAINER_ID
   docker start/stop CONTAINER_ID
   docker rm -f CONTAINER_ID
   docker rmi mysql

   --进入容器内部
   docker ps [-a]
   docker exec -it CONTAINER_ID /bin/bash



