# OpenTracing Java Examples

This repository contains various example apps instrumented with OpenTracing API and framework integrations.

## Start tracing system
Choose tracing system, note that some code changes might be required, depending on which tracer is initialized.

```bash
docker run --rm -it --network=host jaegertracing/all-in-one
docker run --rm -it -p 9411:9411 openzipkin/zipkin
```

## Spring Boot
[Video](https://youtu.be/RvCcWltMY7U)

```bash
eval $(minikube docker-env) 
mvnw clean install && docker build -t spring-boot:latest .
kubectl apply -f <(istioctl kube-inject -f app.yml)
# Optional to delete all -> kubectl delete all,ing -l sb-demo
```

```bash
minikube service jaeger-query --url -n istio-system
export GATEWAY_URL=$(kubectl get po -n istio-system -l istio=ingress -o 'jsonpath={.items[0].status.hostIP}'):$(kubectl get svc istio-ingress -n istio-system -o 'jsonpath={.spec.ports[0].nodePort}')
curl $GATEWAY_URL/hello
```

### Deploy on Kubernetes
```bash
docker build .

```

## JAX-RS (Wilfly Swarm)
[Vide](https://youtu.be/gVwLenPH8SY)

```bash
mvn wildfly-swarm:run
```
