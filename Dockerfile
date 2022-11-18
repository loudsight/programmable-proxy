FROM localhost:5000/loudsight/python-base:0.0.1

RUN apt-get install -y unzip libglib2.0-0 libnss3

ADD target/programmable-proxy-0-SNAPSHOT-bin.zip /opt/web/backend/

RUN install -d /opt/web/backend/resources; \
    cd /opt/web/backend && \
    mkfifo /opt/web/backend/backpipe && \
    unzip backendserver-0-SNAPSHOT-bin.zip && \
    rm -rf backendserver-0-SNAPSHOT-bin.zip && \
    chown -R uknown:uknown . && \
    ln -fs /opt/web/static/ /opt/web/backend/resources/static



COPY entrypoint.sh /home/uknown/entrypoint.sh

USER uknown
ENTRYPOINT /home/uknown/entrypoint.sh
