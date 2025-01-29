```shell
docker exec -it kafka-cont /usr/bin/kafka-topics --list --bootstrap-server localhost:9092
```

```shell
docker exec -it kafka-cont /usr/bin/kafka-console-producer --topic topic1 --bootstrap-server localhost:9092
```

```shell
docker exec -it kafka-cont /usr/bin/kafka-console-producer --topic topic1 --property "parse.key=true" --property "key.separator=:"--bootstrap-server localhost:9092
```

```shell
docker exec -it kafka-cont /usr/bin/kafka-console-consumer --from-beginning --topic topic1 --bootstrap-server localhost:9092
```

```shell
docker exec -it kafka-cont /usr/bin/kafka-console-consumer --group consumer1 --topic topic1 --bootstrap-server localhost:9092
```
