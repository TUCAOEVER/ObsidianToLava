# ObsidianToLava
A Minecraft plugin to improve SkyBlock Sever game experience.  
Using this plugin, players could easily transform Obsidian to Lava using bucket.
## Installation
Put .jar file into /plugins folder then restart the server
## Commands
`/obsidiantolava switch` - players could switch on/off obsidian to lava function  
`/obsidiantolava reload` - reload config and messages
## Permissions
`obsidiantolava.switch` - permission to use command `/obsidiantolava switch`  
`obsidiantolava.reload` - permission to use command `/obsidiantolava reload`
## Config
```yaml
# worlds enable this feature
settings:
    enabled-world:
    - SKYBLOCK
# message will send to players
messages:
    no-permission: '&8[&c!&8]&7 你没有足够的权限以执行该命令.'
    switch-on-otl: '&8[&a!&8]&f 已启用 桶装黑曜石 功能. &7&o(手持铁桶右键黑曜石即可将其转换为岩浆.)'
    switch-off-otl: '&8[&a!&8]&f 已禁用 桶装黑曜石 功能.'
    unknown-command: '&8[&c!&8]&7 未知命令. 输入 &c"/otl switch"&7 以切换 桶装黑曜石功能.'
#messages:
#    no-permission: '&8[&c!&8]&7 You don't have permission to do this.'
#    switch-on-otl: '&8[&a!&8]&f Enabled Obsidian To Lava. &7&o(Right click obsidian with bucket will turn it into lava bucket.)'
#    switch-off-otl: '&8[&a!&8]&f Disabled Obsidian To Lava.'
#    unknown-command: '&8[&c!&8]&7 Unknown Command. Type &c"/otl switch"&7 to switch on/off OTL feature.'
````
