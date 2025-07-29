SUMMARY = "Systemd service to set up virtual CAN interface vcan0"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://vcan0.service"

inherit systemd

do_install() {
    install -D -m 0644 ${WORKDIR}/vcan0.service ${D}${systemd_system_unitdir}/vcan0.service
}

SYSTEMD_SERVICE:${PN} = "vcan0.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"
