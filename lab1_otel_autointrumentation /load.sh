

while :; do
    echo "$i"
    curl http://localhost:8081/banking/pago\?total\=1231\&customerId\=12   
    sleep 3
done