#!/bin/bash

# https://vaneyckt.io/posts/safer_bash_scripts_with_set_euxo_pipefail/
set -Eeuxo pipefail

SCRIPT_PATH="$(
  cd "$(dirname "$0")" >/dev/null 2>&1
  pwd -P
)"

pid_file="$SCRIPT_PATH/.lock"
if [ -f "$pid_file" ] && kill -0 "$(cat "$pid_file")" 2>/dev/null; then
  echo Still running
  exit 1
fi
echo $$ >"$pid_file"

quoted_args="$(printf "${1+ %q}" "$@")"

cd "$SCRIPT_PATH" || exit
export PYTHONPATH=.
venv/bin/python3 scraper.py $quoted_args
