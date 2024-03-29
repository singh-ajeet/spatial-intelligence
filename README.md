# Spatial Intelligence (Latitude, Longitude and Time) - a scalable platform for time series & spatial data

A location intelligence platform to provide insights of  user's behaviour data that helps customers in taking decisions for ad campains and future expensions. We provides - "location", "demography" and "interest" about a POI and a customer after adding "behavior" to it can engage and analyze its user's interests.


 - Process tera-scale events in our Hadoop, Kafka and Apache Spark pipelines
 - Unified platform for real time & batch processing
 - Single platform for OnPrem and cloud deployment
 - User can create his own custom pipelines along with our datasets and customer's datasets
 - Data injestion across different formats - a plain text, parquet, ORC etc.
 - Schema evolution support - robust support for data schemas that change over time
 - Multi-tenant 
 - Resilient
 - Easy debugging and monitoring

Supported tools to injest customer's data: 
  - S3
  - More to come

Processing:
  - Presto for real time (in seconds) ad-hock SQL analytics
  - And Spark for ETL, ML model traning and aggregation
  
NoSQL database connectors:
  - Cassandra
  - MongoDB
  - Kafka
 
RDBMS database connectors: 
  - MySQL
  - PostgreSQL

Deployment environment:
  - Amazon Web Services
  - Docker
  - Kubernetes
  
Monitoring:
  - Prometheus
