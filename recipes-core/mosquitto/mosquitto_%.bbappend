# meta-carles/recipes-mqtt/mosquitto/mosquitto_%.bbappend

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

do_install:append() {
    CONF_FILE="${D}${sysconfdir}/mosquitto/mosquitto.conf"

    # If there is a line starting with bind_address, modify it; if not, add it
    if grep -q "^bind_address" "$CONF_FILE"; then
        sed -i 's/^bind_address.*/bind_address 0.0.0.0/' "$CONF_FILE"
    else
        echo "" >> "$CONF_FILE"
        echo "# Permet connexions externes" >> "$CONF_FILE"
        echo "bind_address 0.0.0.0" >> "$CONF_FILE"
    fi

    # If allow_anonymous already exists, modify it; if not, add it
    if grep -q "^allow_anonymous" "$CONF_FILE"; then
        sed -i 's/^allow_anonymous.*/allow_anonymous true/' "$CONF_FILE"
    else
        echo "" >> "$CONF_FILE"
        echo "# Permet connexions sense autenticació (LAN segura)" >> "$CONF_FILE"
        echo "allow_anonymous true" >> "$CONF_FILE"
    fi
}