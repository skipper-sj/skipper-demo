#! /bin/bash

app_code="skipper_SERVICE"

curl -XPOST -d "`cat template/finance-order-template.json`" logservice2.apitops.com:9200/_template/skipper-demo-template