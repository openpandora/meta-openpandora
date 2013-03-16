PRINC := "${@int(PRINC) + 1}"
FILESEXTRAPATHS_prepend := "${THISDIR}/bluez4-4.101:"

SRC_URI += " file://0001-hciattach_tialt-Implement-texas_change_speed-functio.patch \
             file://firmware_path.patch"

