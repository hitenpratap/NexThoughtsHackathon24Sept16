<nav role="navigation" class="navbar navbar-fixed-top navbar-color-on-scroll">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button data-target="#bs-example-navbar-collapse-1" data-toggle="collapse" class="navbar-toggle"
                    type="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">Brand</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">Link</a></li>
                <sec:ifAllGranted roles="ROLE_MEMBER">
                    <li><a href="${createLink(controller: 'team', action: 'list')}"><i class="fa fa-users"></i> Teams
                    </a>
                    </li>
                    <li><a href="${createLink(controller: 'project', action: 'index')}"><i
                            class="fa fa-code"></i> Projects
                    </a>
                    </li>
                </sec:ifAllGranted>
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">Dropdown <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <sec:ifNotLoggedIn>
                    <li><a href="${createLink(controller: 'login')}"><i class="fa fa-sign-in"></i> Login</a></li>
                </sec:ifNotLoggedIn>
                <sec:ifLoggedIn>
                    <li><a href="javascript:void(0)"><i class="fa fa-user"></i>&nbsp;<sec:username/></a></li>
                    <li><a href="${createLink(controller: 'logout')}"><i class="fa fa-sign-out"></i> Logout</a></li>
                </sec:ifLoggedIn>
            </ul>
        </div>
    </div>
</nav>