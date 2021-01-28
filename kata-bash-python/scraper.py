#!/usr/bin/env python

import logging
from pathlib import Path

import click

import config


@click.command()
@click.option("--log_level", default=str(config.logging['level']),
              help="Log level: FATAL, ERROR, WARNING, INFO and DEBUG")
def scraper(log_level):
    loglevel = getattr(logging, log_level, config.logging['level'])
    logging.basicConfig(filename=config.logging['file'], level=loglevel)

    logging.info('Started')

    print('hello world!')

    logging.info('Finished')


if __name__ == '__main__':
    Path("logs").mkdir(parents=True, exist_ok=True)
    scraper()
