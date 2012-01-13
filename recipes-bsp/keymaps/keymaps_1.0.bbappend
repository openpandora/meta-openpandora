FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PRINC := "${@int(PRINC) + 1}"

SRC_URI_append_omap3-pandora = " file://keymap-extension-2.6.map"

do_install_append_omap3-pandora () {
  install -m 0644 ${WORKDIR}/keymap-*.map     ${D}${sysconfdir}
}
