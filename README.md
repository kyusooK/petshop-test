# 

## Model
www.msaez.io/#/storming/petshop2

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- pet-data-management
- product-purchase
- social-media-interaction
- product-review
- product


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- pet-data-management
```
 http :8088/petProfiles id="id" age="age" size="size" gender="gender" preferences="preferences" needs="needs" allegies="allegies" petType="petType" 
 http :8088/recommendedProducts productType="productType" size="size" age="age" gender="gender" preferences="preferences" photo="photo" petProfileId="petProfileId" 
 http :8088/productProfiles id="id" ingredients="ingredients" 
```
- product-purchase
```
 http :8088/purchasedProducts productId="productId" productName="productName" price="price" petProfileId="petProfileId" 
```
- social-media-interaction
```
 http :8088/socialMediaPosts postId="postId" content="content" imageUrl="imageUrl" 
```
- product-review
```
 http :8088/productReviews reviewId="reviewId" productId="productId" rating="rating" comment="comment" 
```
- product
```
 http :8088/products name="name" price="price" description="description" ingredients="ingredients" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

