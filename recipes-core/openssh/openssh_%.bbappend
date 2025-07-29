# openssh_%bbappend - This file is used to append to the openssh recipe

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://sshd.service"

pkg_postinst_ontarget:${PN} () {
    # Create /var/run/sshd if it does not exist
    mkdir -p /var/run/sshd
    chmod 755 /var/run/sshd

    # Generate keys if they do not exist
    if [ ! -e /etc/ssh/ssh_host_rsa_key ]; then
        echo "Generating SSH host keys..."
        /usr/bin/ssh-keygen -A
    fi
}

do_install:append() {
    install -D -m 0644 ${WORKDIR}/sshd.service ${D}${systemd_system_unitdir}/sshd.service
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "sshd.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"
