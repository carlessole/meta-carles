DESCRIPTION = "Service to auto-connect to WiFi on boot"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://wifi-connect.sh \
            file://wifi-connect.service"

inherit systemd
SYSTEMD_SERVICE:${PN} = "wifi-connect.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/wifi-connect.sh ${D}${bindir}/

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/wifi-connect.service ${D}${systemd_system_unitdir}/
}
