#!/bin/bash

HOST=$1
PORT=$2
shift 2
CMD="$@"

for i in {1..10}; do
  (echo > /dev/tcp/$HOST/$PORT) >/dev/null 2>&1 && break

  echo "Waiting for $HOST:$PORT to be available - Step $i of 15"
  sleep 5
done

exec $CMD
