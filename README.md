# BOOKSTORE-API

#Pre requisites

1. Build bookstore repository with the command "mvn clean install".
2. Install docker and docker-compose


#To bring up postgres and run flyway in local
Open terminal and run below commands
move to the dev-env-tool directory 
        
    cd dev-env-tool
        
run docker-compose
    
    docker-compose -f docker-compose-dev.yml up -d
    
Use sudo if permission issues are reported for above command
    
    sudo docker-compose -f docker-compose-dev.yml up -d

3. Connecting to local host

    
    Application url : 
    
        http://localhost:8080/bookstore/v1/book/   
        
#To bring down postgres container in local
    
    docker-compose -f docker-compose-dev.yml down
