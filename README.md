# istio-insuranceinc

1) Create applications using the provided OpenShift template

2) Inject the istio-proxy container into the DeploymentConfigs: `kubectl -n istio-insuranceinc get dc -o yaml  | istioctl kube-inject -f - | kubectl -n istio-insuranceinc apply -f -`