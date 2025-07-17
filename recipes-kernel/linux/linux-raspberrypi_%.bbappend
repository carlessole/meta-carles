FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://i2c.cfg"

KERNEL_CONFIG_FRAGMENTS += "file://i2c.cfg"
