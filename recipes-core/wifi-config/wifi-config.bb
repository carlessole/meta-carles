DESCRIPTION = "WiFi configuration for automatic connection"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += "file://wpa_supplicant.conf"

do_install() {
    install -d ${D}${sysconfdir}/wpa_supplicant
    install -m 0644 ${WORKDIR}/wpa_supplicant.conf ${D}${sysconfdir}/wpa_supplicant/
}

FILES:${PN} += "${sysconfdir}/wpa_supplicant/wpa_supplicant.conf"
