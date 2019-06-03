echo "Start"
sudo docker build -t s1-movie-catalog-service .
PS=`sudo docker ps --filter publish=8081 -q`
if [ "$PS" != "" ]
then
	echo "Stoping container --"
	sudo docker stop "$PS"
fi
echo "Staring container..."	
sudo docker run -it -d -p 8081:8081 s1-movie-catalog-service	
echo "End"
