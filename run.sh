sudo mvn clean install -DskipTests=true

#sudo rm -rf target/
#sudo mvn clean install

sudo docker stop $(sudo docker ps -aq)

#sudo docker rm $(sudo docker ps -aq)

sudo docker rm imagine_api_1

sudo docker rmi imagine_api

sudo docker-compose up
