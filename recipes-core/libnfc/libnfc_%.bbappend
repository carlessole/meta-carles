FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://i2c/libnfc.conf"

do_install:append() {
    install -d ${D}${sysconfdir}/nfc
    install -m 0644 ${WORKDIR}/i2c/libnfc.conf ${D}${sysconfdir}/nfc/
}

FILES:${PN} += "${sysconfdir}/nfc/libnfc.conf"