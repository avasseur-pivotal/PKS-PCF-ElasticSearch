# Earthquakes demo 
## using SCDF, PCF Elastic Runtime and PKS/Kubo

This demo is part of the CF Summit EU 2017 session and shows both PCF Elastic Runtime and PKS being used side-by-side.

## Pre-requisites:
---
The demo was tested using the following software versions:
- Pivotal CloudFoundry(PCF) v1.11
- Kubo v[CHANGEME]
- Spring Cloud Dataflow(SCDF) v.1.3.0.M2
- Docker v.17.06
- Kubectl client v.1.7.6

The SCDF pipeline uses the following Spring Cloud Stream apps:
- Http Client, [CHANGEME] - Bacon Release (maven) http://bit.ly/Bacon-RELEASE-stream-applications-rabbit-maven
- Custom Elastic Search sink app, which can be found in this repository

It also requires a docker registry account, with the ability to push and pull images. Dockerhub (free) will work just fine.

TODO: USE CF INTEGRATED ROUTING INSTEAD OF EXTERNAL IP ADDRESSES.

## Runnning the demo
---

1. Deploy ElasticSearch and Kibana. Expose it through a Load Balancer service and note the IP address 

$ kubectl run elastic-kibana --image=nshou/elasticsearch-kibana
[TODO: command output]
$ kubectl expose deployment elastic-kibana --name=elastic-kibana-svc --port=9200,5601 --type=LoadBalancer
[TODO: command output]
$ kubectl get services
[TODO: command output]

Create the index in Elastic Search

[TODO: detailed instructions]

Use curl to post the 

2. Build and publish the Spring Cloud Stream ElasticSearch sink app. 

$ cd Elasticsearch-sink/
$ ./mvnw package
[TODO: command output]
$ ./publish.sh
[TODO: command output]
[TODO: clean-up, verify and remove local references from the script above]

The previous command builds and deploys a HTTP server(httpd) docker image to Kubo. We'll use the http server running on Kubernetes to host both our custom SCDF sink app and the data we'll ingest into Elastic Search using the pipeline.

$ kubectl get services
[TODO: command output]
Note down the external IP address. We'll use that on steps 4 and 5 below. [HOST]


3. Start the Spring Cloud Dataflow (SCDF) server locally or deploy it to PCF

Follow the documentation at https://docs.spring.io/spring-cloud-dataflow-server-cloudfoundry/docs/1.3.0.M2/reference/htmlsingle/#getting-started


4. Import the apps we'll use into SCDF

Use the UI or command line to: 
- Builk import the Bacon release apps ()
- Import our custom app:  http://[HOST]/Elasticsearch-sink-<version>.jar

Replace <version> of the jar file with the correct filename. You can find the file at Elasticsearch-sink/target/. Replace [HOST] with the httpd host from step 2.


5. Create and deploy the SCDF pipeline, importing data into Elastic Search

Use the UI or SCDF command line to deploy the following pipeline to SCDF:

stream create --name demo --definition "time --fixed-delay=3000 | httpclient --url-expression='''http://[HOST]/earthquakes.txt''' | splitter --delimiters=\"\\\n\" |elasticsearch" --deploy

Replace [HOST] above with your httpd host from step 2.

TODO: Pass the ES connect info (host:port) to the app
TODO: Find a better trigger than 5min timer

6. Check data is being ingested into ElasticSearch

 You can check the SCDF app logs and verify the number of records directly in Elastic Search:
-- 
curl http://localhost:9200/earthquakes/_refresh
curl http://localhost:9200/earthquakes/_count
--

7. Open the Kibana UI and import the dashboard

Open the Kibana UI at http://[Elastic-Kibana-IP]:5601/

Click on

Using a local file:

file --directory=<path>/earthquakes --filename-pattern=earthquakes.txt --mode=lines | bridge | elasticsearch

5. Deploy the pipeline. The data should land in ElasticSearch

6. Open the Kibana UI at <IP>:5601 and import the dashboard at earthquakes/ncedc-earthquakes-dashboards.json
